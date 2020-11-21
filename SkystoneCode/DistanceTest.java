package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "DistanceTest.java", group = "")

public class DistanceTest extends LinearOpMode {
    private DistanceSensor sensor_range;
    @Override
    
    public void runOpMode(){
        sensor_range = hardwareMap.get(DistanceSensor.class,"sensor_range");
        Rev2mDistanceSensor sensorTimeOfflight = (Rev2mDistanceSensor)sensor_range;
        
        telemetry.update();
        
        waitForStart();
        
        while(opModeIsActive()){
            //telemetry.addData("deviceName",sensorRange.getDeviceName());
            telemetry.addData("range ", String.format("%.01f cm", sensor_range.getDistance(DistanceUnit.CM)));
            telemetry.update();
        }

   }
}
