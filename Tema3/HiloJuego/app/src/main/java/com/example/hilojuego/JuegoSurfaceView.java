package com.example.hilojuego;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class JuegoSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    boolean pantallaInicio = true;
    int anchoPantalla = 0, altoPantalla = 0;
    SurfaceHolder surfaceHolder;
    Context context;
    Hilo hilo;
    Paint p;
    Bitmap b1, b2, b3, fondo1, fondo2;
    Personaje per,per2;
    HashMap<Integer, Point> dedos=new HashMap<>();
    Bitmap[] naves=new Bitmap[6];
Fondo f1,f2;
    public JuegoSurfaceView(Context context) {
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


        hilo = new Hilo();
        p = new Paint();
        p.setColor(Color.WHITE);
        p.setTextSize(60);
        Log.i("tamnan", anchoPantalla + ":" + altoPantalla);
        b1 = BitmapFactory.decodeResource(getResources(), R.drawable.run_00);
        b2 = BitmapFactory.decodeResource(getResources(), R.drawable.run_01);
        b3 = getBitmapFromAssets("run/run_07.png");

        Bitmap[] bitmaps = new Bitmap[10];
        for (int i = 0; i < bitmaps.length; i++) {
            bitmaps[i] = getBitmapFromAssets("run/run_0" + i + ".png");
            bitmaps[i] = escalaAltura(bitmaps[i], altoPantalla / 3);
        }
        per = new Personaje(bitmaps, anchoPantalla / 2, altoPantalla - bitmaps[0].getHeight() - altoPantalla / 10,anchoPantalla,altoPantalla);
        per2 = new Personaje(bitmaps, anchoPantalla / 2, altoPantalla - bitmaps[0].getHeight() - altoPantalla / 10,anchoPantalla,altoPantalla);
        fondo1 = getBitmapFromAssets("fondo1.jpeg");
        fondo1 = Bitmap.createScaledBitmap(fondo1, anchoPantalla, altoPantalla, false);
        Log.i("fondo", "" + fondo1);
        fondo2 = getBitmapFromAssets("fondo2.jpg");
        fondo2 = Bitmap.createScaledBitmap(fondo2, anchoPantalla, altoPantalla, false);
for(int i=0;i<naves.length;i++){
    naves[i]=getBitmapFromAssets("nave"+(i+1)+".png");
}


f1=new Fondo(fondo2,0,30,anchoPantalla);

    }


    public void dibujar(Canvas c) {
        if (pantallaInicio) {
            c.drawBitmap(fondo1, 0, 0, null);
        } else {
            c.drawBitmap(fondo2, 0, 0, null);
            per.dibuja(c);
            per2.dibuja(c);
            c.drawText(anchoPantalla + ":" + altoPantalla, 10, 10 + p.getTextSize(), p);
        }

//        c.drawColor(Color.RED);
        c.drawText(anchoPantalla + ":" + altoPantalla, 10, 10 + p.getTextSize(), p);
//        per.dibuja(c);
f1.dibuja(c);
    for(Map.Entry<Integer,Point> e:dedos.entrySet()){
        c.drawBitmap(naves[e.getKey()],e.getValue().x,e.getValue().y,null);
    }
    }

    public void actualizaFisica() {
        f1.move();
        if (!pantallaInicio) {
            per.move1();
            per2.mover2();
            per.cambiaFrame();
            per2.cambiaFrame();

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
                dedos.put(id,new Point((int)x,(int)y ));

per.setVelocidad(per.getVelocidad()*-1);


                if (pantallaInicio) pantallaInicio = false;
                return true;


            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
dedos.remove(id);

                return true;


            case MotionEvent.ACTION_MOVE:
                for (int i=0;i<event.getPointerCount();i++){
                    dedos.put(event.getPointerId(i),new Point((int)event.getX(i),(int)event.getY(i)));
                }
                return true;

        }


        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.hilo.setFuncionando(true);
        if (this.hilo.getState() == Thread.State.NEW) this.hilo.start();
        if (this.hilo.getState() == Thread.State.TERMINATED) {
            this.hilo = new Hilo();
            this.hilo.start();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        this.anchoPantalla = width;
        this.altoPantalla = height;
        b1 = escalaAltura(b1, altoPantalla / 2);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        this.hilo.setFuncionando(false);
        try {
            hilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public class Hilo extends Thread {
        public boolean funcionando = false;

        public Hilo() {

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
