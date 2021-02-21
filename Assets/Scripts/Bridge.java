// 
// Decompiled by Procyon v0.5.36
// 

package com.defaultcompany.homear;

import com.unity3d.player.UnityPlayer;
import java.io.Serializable;
import android.content.Intent;

public class Bridge
{
    protected static int RESULT_SPEECH;
    protected static String languageSpeech;
    
    public static void OpenSpeechToText(final String prompt) {
        final Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.PARTIAL_RESULTS", true);
        intent.putExtra("android.speech.extra.LANGUAGE", Bridge.languageSpeech);
        intent.putExtra("android.speech.extra.LANGUAGE_PREFERENCE", Bridge.languageSpeech);
        intent.putExtra("android.speech.extra.ONLY_RETURN_LANGUAGE_PREFERENCE", Bridge.languageSpeech);
        intent.putExtra("android.speech.extras.SPEECH_INPUT_MINIMUM_LENGTH_MILLIS", (Serializable)new Long(5000L));
        intent.putExtra("android.speech.extras.SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS", (Serializable)new Long(3000L));
        intent.putExtra("android.speech.extras.SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS", (Serializable)new Long(3000L));
        if (prompt != "") {
            intent.putExtra("android.speech.extra.PROMPT", prompt);
        }
        UnityPlayer.currentActivity.startActivityForResult(intent, Bridge.RESULT_SPEECH);
    }
    
    public static void SettingSpeechToText(final String language) {
        Bridge.languageSpeech = language;
    }
    
    public static void StartRecording() {
        final MainActivity activity = (MainActivity)UnityPlayer.currentActivity;
        activity.OnStartRecording();
    }
    
    public static void StopRecording() {
        final MainActivity activity = (MainActivity)UnityPlayer.currentActivity;
        activity.OnStopRecording();
    }
    
    public static void OpenTextToSpeed(final String text) {
        final MainActivity activity = (MainActivity)UnityPlayer.currentActivity;
        activity.OnStartSpeak(text);
    }
    
    public static void SettingTextToSpeed(final String language, final float pitch, final float rate) {
        final MainActivity activity = (MainActivity)UnityPlayer.currentActivity;
        activity.OnSettingSpeak(language, pitch, rate);
    }
    
    public static void StopTextToSpeed() {
        final MainActivity activity = (MainActivity)UnityPlayer.currentActivity;
        activity.OnStopSpeak();
    }
    
    static {
        Bridge.RESULT_SPEECH = 1;
        Bridge.languageSpeech = "en-US";
    }
}
