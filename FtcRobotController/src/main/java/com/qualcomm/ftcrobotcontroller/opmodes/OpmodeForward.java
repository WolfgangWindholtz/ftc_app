

package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class OpmodeForward extends OpMode {



    MapLoader mapLoader;

    @Override
    public void init() {
        mapLoader = new MapLoader(hardwareMap);
    }

    @Override
    public void loop() {

            /*
            AutoForwardReader reader = new AutoForwardReader();

            AutoForwardSample sample = reader.read();

            AutoForwardProcessor processor = new AutoForwardProcessor();
             */

            Command command = new Command();
            command.powerLevelRight = 1.0;
            command.powerLevelLeft = 1.0;

            Runner runner = new Runner(mapLoader);
            runner.execute(command);

    }

}
