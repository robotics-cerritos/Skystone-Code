package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(name = "Motor3Test.java", group = "")

public class Motor3Test extends LinearOpMode{

    // todo: write your code here
    private DcMotor m3;
    public void runOpMode(){
        m3 = hardwareMap.dcMotor.get("m3");
        m3.setDirection(DcMotor.Direction.REVERSE);
        telemetry.addData("Mode:","Waiting");
        telemetry.update();
        waitForStart();
        telemetry.addData("Mode:","Running");
        telemetry.update();
        if(opModeIsActive()){
            m3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            m3.setMode(DcMotor.RunMode.RESET_ENCODERS);
            m3.setTargetPosition(500);
            
            m3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            m3.setPower(1);
            while(m3.isBusy()){
                telemetry.addData("M3", m3.getCurrentPosition());
                telemetry.update();
            }
            m3.setPower(0);
            
        }

    }

}
