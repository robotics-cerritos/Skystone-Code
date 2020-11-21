package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;

@TeleOp(name = "GyroTest", group = "")
public class GyroTest extends LinearOpMode {

  private BNO055IMU imu;
  private DcMotor m2;
  private DcMotor m4;
  private DcMotor m1;
  private DcMotor m3;
  int x = 0;
  
  public void move(int move){
        m1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        m2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        m3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        m4.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
      //stop and reset encoder, and sets target position for each motor
        m1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m1.setTargetPosition(move);
        m2.setTargetPosition(move);
        m3.setTargetPosition(move);
        m4.setTargetPosition(move);
        
        //run to position
        m1.setMode(DcMotor.RunMode.RUN_TO_POSITION);        
        m2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m4.setMode(DcMotor.RunMode.RUN_TO_POSITION);
  
        //Sets power
        m1.setPower(0.5);
        m2.setPower(0.5);
        m3.setPower(0.5);
        m4.setPower(0.5);
        
        //call telemetry for each motors 
        while(opModeIsActive() && m1.isBusy()){
            telemetry.addData("M1",m1.getCurrentPosition());
            telemetry.addData("M2",m2.getCurrentPosition());
            telemetry.addData("M3",m3.getCurrentPosition());
            telemetry.addData("M4",m4.getCurrentPosition());
            
            telemetry.addData("rot about Z", imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle);
            telemetry.addData("rot about Y", imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).secondAngle);
            telemetry.addData("rot about X", imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).thirdAngle);
        
            telemetry.update();
        }
        // Stopping the drive motors
        m1.setPower(0);
        m2.setPower(0);
        m3.setPower(0);
        m4.setPower(0);
        sleep(50);  
    }
  public void turn(double turn, String direction){
        m1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        m1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        m2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        m3.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        m4.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        
        
        if(direction == "left"){
            while((imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle)<(turn-15)){
        
                m1.setPower(-0.5);
                m2.setPower(0.5);
                m3.setPower(-0.5);
                m4.setPower(0.5);
                telemetry.addData("Running: ","First Left" );
                telemetry.addData("Angle",imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle);
                telemetry.update();
            }
            while(((imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle)<turn)&&(imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle>=(turn-15))){
        
                m1.setPower(-0.15);
                m2.setPower(0.15);
                m3.setPower(-0.15);
                m4.setPower(0.15);
                telemetry.addData("Running: ","Second Left" );
                telemetry.addData("Angle",imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle);
                telemetry.update();
            }
            m1.setPower(0);
            m2.setPower(0);
            m3.setPower(0);
            m4.setPower(0);
        }
        
        else if(direction == "right"){
            while((imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle)>(turn+15)){
        
                m1.setPower(0.5);
                m2.setPower(-0.5);
                m3.setPower(0.5);
                m4.setPower(-0.5);
                telemetry.addData("Running: ","First Right" );
                telemetry.update();
            }
            while(((imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle)>turn)&&(imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle)<(turn+15)){
        
                m1.setPower(0.15);
                m2.setPower(-0.15);
                m3.setPower(0.15);
                m4.setPower(-0.15);
                telemetry.addData("Running: ","Second Right" );
                telemetry.update();
            }
            m1.setPower(0);
            m2.setPower(0);
            m3.setPower(0);
            m4.setPower(0);
        }
    }
        
        
    
  public void runOpMode() {
    imu = hardwareMap.get(BNO055IMU.class, "imu");

    // Create new IMU Parameters object.
    BNO055IMU.Parameters imuParameters = new BNO055IMU.Parameters();
    // Use degrees as angle unit.
    imuParameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
    // Express acceleration as m/s^2.
    imuParameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
    // Initialize IMU.
    imu.initialize(imuParameters);
    
    m2 = hardwareMap.dcMotor.get("m2");
    m4 = hardwareMap.dcMotor.get("m4");
    m1 = hardwareMap.dcMotor.get("m1");
    m3 = hardwareMap.dcMotor.get("m3");
    
    m2.setDirection(DcMotorSimple.Direction.REVERSE);
    m4.setDirection(DcMotorSimple.Direction.REVERSE);
    
    
    
    
    waitForStart();
    while (opModeIsActive()) {
        if(x == 0){
          turn(45.0,"left");
          move(300);
          turn(90.0,"left");
          turn(179,"left");
        }
       x = 1;
        
        // Display orientation info.
        telemetry.addData("rot about Z", imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle);
        telemetry.addData("rot about Y", imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).secondAngle);
        telemetry.addData("rot about X", imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).thirdAngle);
        
        telemetry.update();
      
    }
  }
}
