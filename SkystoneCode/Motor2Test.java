package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(name = "Motor2Test.java", group = "")

public class Motor2Test extends LinearOpMode{

    // todo: write your code here
    private DcMotor m2;
    public void runOpMode(){
        m2 = hardwareMap.dcMotor.get("m2");
        telemetry.addData("Mode:","Waiting");
        telemetry.update();
        waitForStart();
        telemetry.addData("Mode:","Running");
        telemetry.update();
        if(opModeIsActive()){
            m2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            m2.setMode(DcMotor.RunMode.RESET_ENCODERS);
            m2.setTargetPosition(500);
            
            m2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            m2.setPower(1);
            while(m2.isBusy()){
                telemetry.addData("M2", m2.getCurrentPosition());
                telemetry.update();
            }
            m2.setPower(0);
            
        }

    }

}
