package test;

import java.util.Scanner;

public class Travel {


	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		int gasTank = 0;
		int stoppedGS = 0;
		System.out.print("Enter number of Gas Stations:");
		int N = keyboard.nextInt();
		int gas[] = new int[N];
		int cost[] = new int[N];

		// reading gasInput 
		System.out.print("(Note: Enter the numbers one at a time. ");
		System.out.println("Enter the amount of gas on each stations:");
		for(int i = 0; i < N; i++){
			gas[i] = keyboard.nextInt();
		}

		// reading costInput
		System.out.print("(Note: Enter the numbers one at a time. ");
		System.out.println("Enter the costing amount of required gas to travel to next station:");
		for(int i = 0; i < N; i++){
			cost[i] = keyboard.nextInt();
		}

		
		loop1:
		for(int i = 0; i < N; i++){

			//Determines where can possibly start
			if(gas[i] >= cost[i]){
				int startingIndex = i;
				gasTank = gas[i];

				//return index to 0 if it is already the last element
				if(i == N-1){
					i = 0;
				}

				
				for(int i1 = i+1 ; i1 < N; i1++){

					stoppedGS++;


					if(i1 == 0){

						//successfully traveled back to starting index
						if(stoppedGS == 5){
							gasTank = gasTank - cost[N-1];
							if(gasTank == 0){
								System.out.print(startingIndex);
								break loop1;
							}
						}

						gasTank = gasTank - cost[N-1] + gas[i1];

					}else{

						//successfully traveled back to starting index
						if(stoppedGS == 5){
							gasTank = gasTank - cost[i1-1];
							if(gasTank == 0){
								System.out.print(startingIndex);
								break loop1;
							}
						}

						gasTank = gasTank - cost[i1-1] + gas[i1];

					}

					//not enough gas to travel to other gas station
					if(gasTank < cost[i1]){
						System.out.println(-1);
						break loop1;
					}


					//didn't get to travel around
					if(i1 != startingIndex && gasTank == 0 && stoppedGS == N-1){
						System.out.println(-1);
						break loop1;
					}

					//can still travel more after finishing one round
					if(stoppedGS == N && gasTank > cost[i1]){
						System.out.print(-1);
						break loop1;
					}


					if(i1 == N-1 && stoppedGS != N && gasTank != 0){
						i1 = -1;
					}


				}

				//break if no appropriate starting point
				}else if(i == N){
					System.out.print(-1);
					break;
				}

		}

		keyboard.close();

	}

}
