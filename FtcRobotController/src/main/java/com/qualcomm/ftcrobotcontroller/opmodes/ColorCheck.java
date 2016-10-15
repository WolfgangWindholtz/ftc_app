package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;


/**
 * Created by wolfie on 10/8/16.
 */

public class ColorCheck extends OpMode {



    DcMotor motor1;
    DcMotor motor2;
    DcMotor motor3;
    DcMotor motor4;
    GyroSensor gyro;
    ColorSensor colorSensor;
    int power;

    @Override
    public void init() {
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
    public void loop() {


        forwardWhenRed();
        backwardWhenBlue();
        motor1.setPower(power);
        motor2.setPower(power);
        motor3.setPower(power);
        motor4.setPower(power);
    }

    public void forwardWhenRed(){
        if(colorSensor.blue() < colorSensor.red())
        {
            power = 1;
        }
    }
    public void backwardWhenBlue(){
        if(colorSensor.red() < colorSensor.blue())
        {
            power = -1;
        }
    }

}


