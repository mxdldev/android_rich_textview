package com.richtextview.example;

import com.daquexian.flexiblerichtextview.Attachment;

/**
 * Description: <ExampleAttachment><br>
 * Author:      mxdl<br>
 * Date:        2025/3/26<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class ExampleAttachment extends Attachment {
    private String mText;
    private String mId;
    private boolean mIsImage;
    private String mUrl;

    public ExampleAttachment(String text, String id, boolean isImage, String url) {
        this.mText = text;
        this.mId = id;
        this.mIsImage = isImage;
        this.mUrl = url;
    }

    @Override
    public String getUrl() {
        return mUrl;
    }

    @Override
    public String getText() {
        return mText;
    }

    @Override
    public String getAttachmentId() {
        return mId;
    }

    @Override
    public boolean isImage() {
        return mIsImage;
    }
}