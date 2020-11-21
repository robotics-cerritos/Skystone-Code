package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(name = "Motor1Test.java", group = "")

public class Motor1Test extends LinearOpMode{

    // todo: write your code here
    private DcMotor m1;
    public void runOpMode(){
        m1 = hardwareMap.dcMotor.get("m1");
        m1.setDirection(DcMotor.Direction.REVERSE);
        
        
        telemetry.addData("Mode:","Waiting");
        telemetry.update();
        waitForStart();
        telemetry.addData("Mode:","Running");
        telemetry.update();
        if(opModeIsActive()){
            m1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            m1.setMode(DcMotor.RunMode.RESET_ENCODERS);
            m1.setTargetPosition(500);
            
            m1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            m1.setPower(1);
            while(m1.isBusy()){
                telemetry.addData("M1", m1.getCurrentPosition());
                telemetry.update();
            }
            m1.setPower(0);
            
        }

    }

}
