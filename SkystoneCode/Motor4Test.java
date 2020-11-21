package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(name = "Motor4Test.java", group = "")

public class Motor4Test extends LinearOpMode{

    // todo: write your code here
    private DcMotor m4;
    public void runOpMode(){
        m4 = hardwareMap.dcMotor.get("m4");
        telemetry.addData("Mode:","Waiting");
        telemetry.update();
        waitForStart();
        telemetry.addData("Mode:","Running");
        telemetry.update();
        if(opModeIsActive()){
            m4.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            m4.setMode(DcMotor.RunMode.RESET_ENCODERS);
            m4.setTargetPosition(500);
            
            m4.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            m4.setPower(1);
            while(m4.isBusy()){
                telemetry.addData("M4", m4.getCurrentPosition());
                telemetry.update();
            }
            m4.setPower(0);
            
        }

    }

}
