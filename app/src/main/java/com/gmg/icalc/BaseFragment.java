package com.gmg.icalc;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.view.View;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private Unbinder unbinder;

    public void scrollToTop() {
    }

    public void refreshView(boolean setRefreshing) {
    }

    public void addItem() {}

    public BaseFragment(){
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /*protected void createImagePickerDialog(final Activity activity, final File output, String title){
        int hasCameraPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.CAMERA);
        int hasReadPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);
        int hasWritePermission  = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        List<String> permissions = new ArrayList<>();

        if( hasCameraPermission != PackageManager.PERMISSION_GRANTED ) {
            permissions.add( Manifest.permission.CAMERA );
        }

        if( hasReadPermission != PackageManager.PERMISSION_GRANTED ) {
            permissions.add( Manifest.permission.READ_EXTERNAL_STORAGE );
        }

        if( hasWritePermission != PackageManager.PERMISSION_GRANTED ) {
            permissions.add( Manifest.permission.WRITE_EXTERNAL_STORAGE );
        }

        if (!permissions.isEmpty()) {
            requestPermissions(permissions.toArray(new String[permissions.size()]), RequestCodeList.PHOTO_OPERATIONS);
        } else {
            new AlertDialog.Builder(activity)
                    .setTitle(title)
                    .setItems(getResources().getStringArray(R.array.select_image_source_arr), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which){
                                case 0:
                                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                    if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
                                        ContentValues values = new ContentValues(1);
                                        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpg");
                                        Uri fileUri;
                                        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
                                            fileUri = FileProvider.getUriForFile(activity,
                                                    "com.med.fast.fileprovider",
                                                    output);
                                        } else {
                                            fileUri = activity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                                        }

                                        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                                        cameraIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                                    } else {
                                        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(output));
                                    }

                                    startActivityForResult(cameraIntent, RequestCodeList.CAMERA);
                                    dialog.dismiss();
                                    break;
                                case 1:
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN // Permission was added in API Level 16
                                            && ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
                                            != PackageManager.PERMISSION_GRANTED) {
                                        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PermissionCodeList.READ_EXTERNAL_STORAGE);
                                    } else {
                                        if (Build.VERSION.SDK_INT < 19) {
                                            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                                            intent.setType("image*//* video*//*");
                                            intent.setType("image*//*");
                                            startActivityForResult(Intent.createChooser(intent, getResources().getString(R.string.select_image)),RequestCodeList.GALLERY);
                                        } else {
                                            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                                            intent.setType("image*//* video*//*");
                                            intent.setType("image*//*");
                                            intent.putExtra(Intent.EXTRA_MIME_TYPES, new String[]{"image*//*"*//*, "video*//**//*"*//*});
                                            startActivityForResult(intent, RequestCodeList.GALLERY);
                                            dialog.dismiss();
                                        }
                                    }
                                    dialog.dismiss();
                                    break;
                            }
                        }
                    })
                        *//*.setPositiveButton(R.string.fromCamera, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })*//*
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
        }
    }*/

    /*public CreatedImageModel createImageFile() throws IOException {
        CreatedImageModel createdImageModel = new CreatedImageModel();
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.dateFormatPicture, Locale.getDefault());
        String imageFileName = simpleDateFormat.format(date);

        File storageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + MediaUtils.FMR_DIR);
        File image;

        if (externalMemoryAvailable()) {
            image = File.createTempFile(
                    imageFileName,  *//* prefix *//*
                    ".jpg",         *//* suffix *//*
                    storageDir      *//* directory *//*
            );
        } else {
            image = new File(storageDir, imageFileName + ".jpg");
        }

        storageDir.mkdirs();
        // Save a file: path for use with ACTION_VIEW intents
        createdImageModel.currentMediaPath = "file:" + image.getAbsolutePath();
        createdImageModel.mDestinationUri = Uri.parse(createdImageModel.currentMediaPath);
        createdImageModel.image = image;
        return createdImageModel;
    }*/

    public boolean externalMemoryAvailable() {
        if (Environment.isExternalStorageRemovable()) {
            //device support sd card. We need to check sd card availability.
            String state = Environment.getExternalStorageState();
            return state.equals(Environment.MEDIA_MOUNTED) || state.equals(
                    Environment.MEDIA_MOUNTED_READ_ONLY);
        } else {
            //device not support sd card.
            return false;
        }
    }
}
