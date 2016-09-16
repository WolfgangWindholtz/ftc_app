package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class SummerRoboticObjects extends OpMode {

    public SummerRoboticObjects() {

    }

    MapLoader mapLoader;

    @Override
    public void init() {
        mapLoader = new MapLoader(hardwareMap);
    }

    @Override
    public void loop() {

        SensorReader reader = new SensorReader(gamepad1, gamepad2);
        Sample sample = reader.read();

        Processor processor = new Processor();
        Command command = processor.consume(sample);

        Runner runner = new Runner(mapLoader);
        runner.execute(command);

    }

}