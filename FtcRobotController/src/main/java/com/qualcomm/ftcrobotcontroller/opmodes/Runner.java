package com.qualcomm.ftcrobotcontroller.opmodes;


public class Runner {

    MapLoader mapLoader;

    Runner(MapLoader mapLoader) {
        this.mapLoader = mapLoader;
    }

    public void execute(Command command) {

        // write the values to the motors
        mapLoader.motor1.setPower(command.powerLevelRight);
        mapLoader.motor2.setPower(command.powerLevelRight);
        mapLoader.motor3.setPower(command.powerLevelLeft);
        mapLoader.motor4.setPower(command.powerLevelLeft);

    }
}
