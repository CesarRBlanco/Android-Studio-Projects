package com.example.theguardian;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

class Game extends SurfaceView implements SurfaceHolder.Callback {
    boolean movement = false;
    int anchoPantalla = 0, altoPantalla = 0;
    SurfaceHolder surfaceHolder;
    Context context;
    GameThread gameThread;
    Paint p;
    Character character;
    Bitmap  fondo1;
    HashMap<Integer, Point> dedos=new HashMap<>();

    Background f1,f2;
    public Game(Context context) {
        super(context);
        this.context = context;
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            windowManager.getDefaultDisplay().getRealMetrics(dm); // métricas de la pantalla con tamaño reducido
        } else {
            windowManager.getDefaultDisplay().getMetrics(dm); // métricas de la pantalla con tamaño reducido
        }
        anchoPantalla = dm.widthPixels;
        altoPantalla = dm.heightPixels;

        gameThread = new GameThread();
        p = new Paint();
        p.setColor(Color.WHITE);
        p.setTextSize(60);
        Bitmap[] bitmaps = new Bitmap[5];
        for (int i = 0; i < bitmaps.length; i++) {
            bitmaps[i] = getBitmapFromAssets("sprite.png");
            bitmaps[i] = escalaAltura(bitmaps[i], altoPantalla / 6);
        }
        character=new Character(bitmaps, 20,20,anchoPantalla,altoPantalla);
        fondo1 = getBitmapFromAssets("background.png");
        fondo1 = Bitmap.createScaledBitmap(fondo1, anchoPantalla, altoPantalla, false);


    }


    public void dibujar(Canvas c) {

            c.drawBitmap(fondo1, 0, 0, null);
character.dibuja(c);

    }

    public void actualizaFisica() {
        if(movement){

        character.mover();
        character.cambiaFrame();
        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int accion = event.getActionMasked();
        int indice=event.getActionIndex();
        int id=event.getPointerId(indice);
        float x = event.getX(indice);
        float y = event.getY(indice);


        switch (accion) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:

    movement=true;


            return true;


            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:

                movement=false;
                return true;

        }
            return super.onTouchEvent(event);
  }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.gameThread.setFuncionando(true);
        if (this.gameThread.getState() == Thread.State.NEW) this.gameThread.start();
        if (this.gameThread.getState() == Thread.State.TERMINATED) {
            this.gameThread = new GameThread();
            this.gameThread.start();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        this.anchoPantalla = width;
        this.altoPantalla = height;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        this.gameThread.setFuncionando(false);
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public class GameThread extends Thread {
        public boolean funcionando = false;

        public GameThread() {

        }

        public boolean isFuncionando() {
            return funcionando;
        }

        public void setFuncionando(boolean funcionando) {
            this.funcionando = funcionando;
        }

        @Override
        public void run() {
            while (funcionando) {
                Canvas c = null;
                if (!surfaceHolder.getSurface().isValid()) {
                    continue;
                }
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        c = surfaceHolder.lockHardwareCanvas();
                    } else {
                        c = surfaceHolder.lockCanvas();
                    }
                    synchronized (surfaceHolder) {
                        actualizaFisica();
                        dibujar(c);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (c != null) {
                        surfaceHolder.unlockCanvasAndPost(c);
                    }
                }
            }
        }
    }

    public Bitmap getBitmapFromAssets(String fichero) {
        try {
            InputStream is = context.getAssets().open(fichero);
            return BitmapFactory.decodeStream(is);
        } catch (IOException e) {
            return null;
        }
    }


    public Bitmap escalaAltura(int res, int nuevoAlto) {
        Bitmap bitmapAux = BitmapFactory.decodeResource(context.getResources(), res);
        return escalaAltura(bitmapAux, nuevoAlto);
    }


    public Bitmap escalaAltura(Bitmap bitmapAux, int nuevoAlto) {
        if (nuevoAlto == bitmapAux.getHeight()) return bitmapAux;
        return bitmapAux.createScaledBitmap(bitmapAux, (bitmapAux.getWidth() * nuevoAlto) /
                bitmapAux.getHeight(), nuevoAlto, true);
    }
}
