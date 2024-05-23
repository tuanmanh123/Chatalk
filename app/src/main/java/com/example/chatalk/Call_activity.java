package com.example.chatalk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;

import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallService;
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig;
import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoAcceptCallInvitationButton;
import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton;
import com.zegocloud.uikit.service.defines.ZegoUIKitUser;

import java.util.Collections;

public class Call_activity extends AppCompatActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ZegoSendCallInvitationButton video_call_btn,voice_call_btn;
        String otherID,otherUsername;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        String userID = getIntent().getStringExtra("userID");
        String userName = getIntent().getStringExtra("userName");
        otherID = getIntent().getStringExtra("otherID");
        otherUsername=getIntent().getStringExtra("otherName");

            video_call(otherID,otherUsername);


            voice_call(otherID,otherUsername);

    }

        protected void video_call(String otherID,String otherName){
            ZegoSendCallInvitationButton video_call_btn=findViewById(R.id.video_call_btn);
        video_call_btn.setIsVideoCall(true);
        video_call_btn.setResourceID("zego_uikit_call"); // Please fill in the resource ID name that has been configured in the ZEGOCLOUD's console here.
        video_call_btn.setInvitees(Collections.singletonList(new ZegoUIKitUser(otherID,otherName)));
    }
    protected void voice_call(String otherID,String otherName){
        ZegoSendCallInvitationButton voice_call_btn=findViewById(R.id.voice_call_btn);
        voice_call_btn.setIsVideoCall(false);
        voice_call_btn.setResourceID("zego_uikit_call"); // Please fill in the resource ID name that has been configured in the ZEGOCLOUD's console here.
        voice_call_btn.setInvitees(Collections.singletonList(new ZegoUIKitUser(otherID,otherName)));
    }
}