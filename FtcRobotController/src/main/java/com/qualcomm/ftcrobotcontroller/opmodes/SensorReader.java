package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

public class SensorReader {

    // tank drive
    // note that if y equal -1 then joystick is pushed all of the way forward.

    Gamepad gamepad1;
    Gamepad gamepad2;

    public SensorReader(Gamepad gamepad1, Gamepad gamepad2) {
      this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
    }

    public Sample read() {
        Sample sample = new Sample();

        sample.pad1Left  = -gamepad1.left_stick_y;
        sample.pad1Right = -gamepad1.right_stick_y;

        return sample;
    }
}
