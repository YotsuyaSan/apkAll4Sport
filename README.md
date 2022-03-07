# apkAll4Sport

APIConnection usage

```java

    try {
        String res = null;
        res = APIConnection.get("http://localhost/request");
        Log.e("Request result: ", res);
    } catch(IOException e) {
        Log.e("Error while trying to request API: ", e.toString());
    }


```