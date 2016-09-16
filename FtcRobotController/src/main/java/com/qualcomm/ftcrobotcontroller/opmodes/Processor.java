package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.util.Range;

public class Processor {
    Processor() { }

    public Command consume(Sample sample){

        // clip the right/left values so that the values never exceed +/- 1
        double right = Range.clip(sample.pad1Right, -1, 1);
        double left = Range.clip(sample.pad1Left, -1, 1);

        // scale the joystick value to make it easier to control
        // the robot more precisely at slower speeds.
        Command command = new Command();
        command.powerLevelLeft = (float) scaleInput(left);
        command.powerLevelRight = (float) scaleInput(right);
        return(command);
    }

    double scaleInput(double dVal)  {
        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

        // get the corresponding index for the scaleInput array.
        int index = (int) (dVal * 16.0);

        // index should be positive.
        if (index < 0) {
            index = -index;
        }

        // index cannot exceed size of array minus 1.
        if (index > 16) {
            index = 16;
        }

        // get value from the array.
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        // return scaled value.
        return dScale;
    }

}
