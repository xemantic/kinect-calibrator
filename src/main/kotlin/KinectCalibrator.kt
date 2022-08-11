package com.xemantic.kinect.calibrator

import org.openrndr.application
import org.openrndr.extra.kinect.v1.Kinect1

fun main() = application {
  configure {
    width = 768
    height = 576
  }
  program {
    val kinect = extend(Kinect1())
    val device = kinect.openDevice()
    device.depthCamera.flipH = true // to make a mirror
    device.depthCamera.enabled = true
    extend {
      drawer.image(device.depthCamera.currentFrame)
    }
  }
}
