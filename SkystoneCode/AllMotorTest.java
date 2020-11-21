package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(name = "AllMotorTest.java", group = "")
public class AllMotorTest extends LinearOpMode{
    
    // todo: write your code here
    private DcMotor m1;
    private DcMotor m2;
    private DcMotor m3;
    private DcMotor m4;
    private DcMotor m5;
    public void runOpMode(){ 
        m2 = hardwareMap.dcMotor.get("m2");
        m4 = hardwareMap.dcMotor.get("m4");
        m1 = hardwareMap.dcMotor.get("m1");
        m3 = hardwareMap.dcMotor.get("m3");
        //m5 = hardwareMap.dcMotor.get("m5");
        m1.setDirection(DcMotor.Direction.REVERSE);
        m3.setDirection(DcMotor.Direction.REVERSE);
        telemetry.addData("Mode:","Waiting");
        telemetry.update();
        waitForStart();
        telemetry.addData("Mode:","Running");
        telemetry.update();
        if(opModeIsActive()){
            m1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            m2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            m3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            m4.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            //m5.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            m1.setMode(DcMotor.RunMode.RESET_ENCODERS);
            m2.setMode(DcMotor.RunMode.RESET_ENCODERS);
            m3.setMode(DcMotor.RunMode.RESET_ENCODERS);
            m4.setMode(DcMotor.RunMode.RESET_ENCODERS);
            //m5.setMode(DcMotor.RunMode.RESET_ENCODERS);
            m1.setTargetPosition(662);
            m2.setTargetPosition(662);
            m3.setTargetPosition(662);
            m4.setTargetPosition(662);
            //m5.setTargetPosition(4000);
            
            m1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            m2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            m3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            m4.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            //m5.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            
            m1.setPower(0.5);
            m2.setPower(0.5);
            m3.setPower(0.5);
            m4.setPower(0.5);
            //m5.setPower(1);
            while(m1.isBusy()){
                telemetry.addData("M1", m1.getCurrentPosition());
                telemetry.update();
            }
            m1.setPower(0);
            m2.setPower(0);
            m3.setPower(0);
            m4.setPower(0);
            //m5.setPower(0);
            
        

    }

}

        

    }


