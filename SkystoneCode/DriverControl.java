package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "DriverControl.java", group = "")
public class DriverControl extends LinearOpMode
{

  private DcMotor m2;
  private DcMotor m4;
  private DcMotor m1;
  private DcMotor m3;
  private DcMotor m5;
  private DcMotor m6;
  private DcMotor outtake;
  private Servo  grabber;
  private DcMotor raiseIntk;
  private Servo clamp;
  private Servo rotateClaw;
  private double power = 1.0;
  private int level = 0;
  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    m2 = hardwareMap.dcMotor.get("m2");
    m4 = hardwareMap.dcMotor.get("m4");
    m1 = hardwareMap.dcMotor.get("m1");
    m3 = hardwareMap.dcMotor.get("m3");
    m5 = hardwareMap.dcMotor.get("intakeLeft");
    m6 = hardwareMap.dcMotor.get("intakeRight");
    grabber = hardwareMap.servo.get("grabber");
    clamp = hardwareMap.servo.get("clampActivator");
    rotateClaw = hardwareMap.servo.get("rotateClaw");
    raiseIntk = hardwareMap.dcMotor.get("raiseIntake");
    outtake = hardwareMap.dcMotor.get("outtake");
    outtake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    // Reverse some of the drive motors.
    waitForStart();
    m2.setDirection(DcMotorSimple.Direction.REVERSE);
    m4.setDirection(DcMotorSimple.Direction.REVERSE);
    m6.setDirection(DcMotorSimple.Direction.REVERSE);
    
    
      while (opModeIsActive()) {
        // Put loop blocks here.
  
        if(gamepad1.b){
          power = 0.4;
        }
        else if(gamepad1.a){
          power = 1.0;
        }
        double drive = -power * gamepad1.left_stick_y;
        double strafe = power * gamepad1.left_stick_x;
        double rotate = power * gamepad1.right_stick_x;
        
        m1.setPower(drive + strafe + rotate);
        m2.setPower(drive - strafe - rotate);
        m3.setPower(drive - strafe + rotate);
        m4.setPower(drive + strafe - rotate);
        outtake.setPower(gamepad2.right_stick_y);
        raiseIntk.setPower(-gamepad1.right_trigger);
        raiseIntk.setPower(gamepad1.left_trigger);
        if(gamepad2.dpad_up){
          clamp.setPosition(1.0);
        }
        else if(gamepad2.dpad_down){
          clamp.setPosition(0.2);
        }
        if(gamepad2.dpad_left){
          rotateClaw.setPosition(0.08);
        }
        else if(gamepad2.dpad_right){
          rotateClaw.setPosition(1.0);
          
        }
        if(gamepad1.right_bumper){
          m5.setPower(1);
          m6.setPower(1);
        }
        else if(gamepad1.left_bumper){
          m5.setPower(-1);
          m6.setPower(-1);
        }
        else{
          m5.setPower(0);
          m6.setPower(0);
          
        }
        
     
        if(gamepad1.x){
          grabber.setPosition(1.0);
          
        }
        else if(gamepad1.y){
          grabber.setPosition(0.0);
          
        }
        telemetry.addData("Outtake position: ", outtake.getCurrentPosition());
        telemetry.addData("M1", m1.getPower());
        telemetry.addData("M2", m2.getPower());
        telemetry.addData("M4", m4.getPower());
        telemetry.addData("M3", m3.getPower());
        telemetry.addData("Rotate Claw Position",rotateClaw.getPosition() );
        telemetry.update();
      }
        
      }
    }
  

