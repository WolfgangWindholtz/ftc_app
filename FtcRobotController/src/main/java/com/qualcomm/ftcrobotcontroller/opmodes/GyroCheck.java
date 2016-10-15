package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;

/**
 * Created by wolfie on 10/8/16.
 */

public class GyroCheck extends OpMode {

    DcMotor motor1;
    DcMotor motor2;
    DcMotor motor3;
    DcMotor motor4;
    GyroSensor gyro;
    ColorSensor colorSensor;
    double powerLeft = -1;
    double powerRight = 1;
    double degrees;

    @Override
    public void init(){
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");
        motor4 = hardwareMap.dcMotor.get("motor4");
        gyro = hardwareMap.gyroSensor.get("gyro");
        colorSensor = hardwareMap.colorSensor.get("colorSensor");
        motor1.setDirection(DcMotor.Direction.REVERSE);
        motor2.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop(){
        degrees = gyro.getRotation();
        gyrocheck();
        motor1.setPower(powerLeft);
        motor2.setPower(powerLeft);
        motor3.setPower(powerRight);
        motor4.setPower(powerRight);
    }

    public void gyrocheck() {
        if (degrees<=60.0){
            powerLeft = 0;
            powerRight = 0;
        }
    }

}
