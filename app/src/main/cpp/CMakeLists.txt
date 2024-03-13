cmake_minimum_required(VERSION 3.22.1)
project("bandmates-audio-processing-android")
add_library(${CMAKE_PROJECT_NAME} SHARED main.cpp)
include_directories(include)
set(libs ${CMAKE_CURRENT_SOURCE_DIR}/libs/${ANDROID_ABI})
target_link_libraries(${CMAKE_PROJECT_NAME}
        ${libs}/libavcodec.so
        ${libs}/libavdevice.so
        ${libs}/libavfilter.so
        ${libs}/libavformat.so
        ${libs}/libavutil.so
        ${libs}/libbandmates-audio-processing.so
        ${libs}/libswresample.so
        ${libs}/libswscale.so
        android
        log)
