 Test code shown below,
void test_jpeg_thumbnail() {
    android.media.ExifInterface exif;
    try {
        String path = "/sdcard/test.jpg";
        exif = new android.media.ExifInterface(path);
        byte[] thumb = exif.getThumbnail();
        if (thumb.length != 2440) {
            Log.e("test_jpeg_thumbnail","thumb.length not equal to 2440");
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(thumb, 0, thumb.length, options);
        int width = options.outWidth;
        int height = options.outHeight;
        if (width < 0) {
            Log.e("test_jpeg_thumbnail","failed to decode thumbnail");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
} 
