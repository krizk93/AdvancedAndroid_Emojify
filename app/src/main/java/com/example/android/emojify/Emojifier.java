package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by Karim on 27-Apr-18.
 */

 class Emojifier {

    private static final String TAG = "Emojifier";

     static void detectFaces(Context context, Bitmap bitmap){

        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

            Frame frame = new Frame.Builder().setBitmap(bitmap).build();

            SparseArray<Face> faces = detector.detect(frame);

            Log.v(TAG, "Faces detected = " + faces.size());

            if (faces.size() == 0) {
                Toast.makeText(context, "No Faces detected", Toast.LENGTH_LONG).show();
            }


        detector.release();

    }
}
