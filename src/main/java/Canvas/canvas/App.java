package Canvas.canvas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import Canvas.object.Canvas;

public class App {
	
	private Canvas canvas;
	public App() {
         canvas = new Canvas();
    }
	public static void main(String[] args) {
		App app = new App();
        Scanner scan = new Scanner(System.in);
        String command = new String();
        while(!command.equals("Q")) {
            System.out.println("\nEnter command:");
            command = scan.nextLine();
            app.create(command);
        }
        System.out.println("Thank you");
        scan.close();

	}
	private void create(String command) throws NumberFormatException {
        char ch = command.charAt(0);
        String[] cmd;
        try {
            switch(ch) {
                case 'C' :
                    cmd = command.split(" ");
                    this.canvas = new Canvas(Integer.parseInt(cmd[1]),Integer.parseInt(cmd[2]));
                    System.out.println(this.canvas.renderCanvas());
                    break;
                case 'L' :
                    cmd = command.split(" ");
                    this.canvas.createLine(Integer.parseInt(cmd[1]),Integer.parseInt(cmd[2]),Integer.parseInt(cmd[3]),Integer.parseInt(cmd[4]),'X');
                    System.out.println(this.canvas.renderCanvas());
                    break;
                case 'R' :
                    cmd = command.split(" ");
                    this.canvas.rectangle(Integer.parseInt(cmd[1]),Integer.parseInt(cmd[2]),Integer.parseInt(cmd[3]),Integer.parseInt(cmd[4]),'X');
                    System.out.println(this.canvas.renderCanvas());
                    break;
                case 'B' :
                    cmd = command.split(" ");
                    this.canvas.bucketFill(Integer.parseInt(cmd[1]),Integer.parseInt(cmd[2]),cmd[3].charAt(0));
                    System.out.println(this.canvas.renderCanvas());
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nInvalid command. Try again!!\n");
        } catch (Exception e) {
            System.out.println("\nError Occurred : " + e.getMessage() + "\nPlease try again");
        }
    }
}
