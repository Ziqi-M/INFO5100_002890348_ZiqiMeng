package com.example.imagemanagementtool;

import com.example.imagemanagementtool.exception.UnknownFormatException;

public interface ImageInfo {
    String getImageName();
    String getWidth();
    String getHeight();
    String getFileSizeinMB();
    String getImageFormat() throws UnknownFormatException;
}
