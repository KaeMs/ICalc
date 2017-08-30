# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\Kevin\AppData\Local\Android\Sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keep class com.gmg.icalc.** {*;}
-dontwarn com.gmg.icalc.**


##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# Gson specific classes
-keep class sun.misc.** { *; }
-dontwarn sun.misc.**
#-keep class com.google.gson.stream.** { *; }
# Application classes that will be serialized/deserialized over Gson
# default
-keep class com.sample.package.models.** { *; } # sample only cant public package right now
##---------------End: proguard configuration for Gson  ----------

-keep class com.google.gson
-keep class Gson**
-keepclassmembers class Gson** {
    *;
}

## OkHttp
-keep class okhttp3.internal.** { *; }
-dontwarn okhttp3.internal.**
## okio?
-keep class java.nio.file.** { *; }
-dontwarn java.nio.file.**
-keep class org.codehaus.mojo.animal_sniffer.** { *; }
-dontwarn org.codehaus.mojo.animal_sniffer.**

## ButterKnife
-keep class **$$ViewBinder { *; }
