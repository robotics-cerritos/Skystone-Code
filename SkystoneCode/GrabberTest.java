package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "GrabberTest.java", group = "")

public class GrabberTest extends LinearOpMode {

    private CRServo grabber; 
    
    
    public void runOpMode(){
        waitForStart();
        
        grabber = hardwareMap.crservo.get("grabber");
        
        while(opModeIsActive()){
            grabber.setPower(1.0);
            sleep(500);
        
            telemetry.addData("grabber power", grabber.getPower());
            telemetry.update();
            grabber.setPower(0.0);    
        }
        
}
}
