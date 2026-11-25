import java.util.ArrayList;
import java.util.Scanner;

  public class main {

      public static int findPlayer(ArrayList<Integer> playerId, int id) {
          for (int i = 0; i < playerId.size(); i++) {
              if (playerId.get(i) == id) return i;
          }
          return -1;
      }
  
      public static int insertPlayer(ArrayList<Integer> playerId, ArrayList<Integer> scores, int id, int score) {
          int p = 0;
          while (p < scores.size() && scores.get(p) > score) p++;
          scores.add(p, score);
          playerId.add(p, id);
          return playerId.size();
      }

      public static int removeBelow(ArrayList<Integer> playerId, ArrayList<Integer> scores, int threshold) {
          for (int i = scores.size() - 1; i >= 0; i--) {
              if (scores.get(i) < threshold) {
                  scores.remove(i);
                  playerId.remove(i);
              }
          }
          return playerId.size();
      }

      public static boolean updateScore(ArrayList<Integer> playerId, ArrayList<Integer> scores, int id, int newScore) {
          if (newScore < 0) return false;
          int index = playerId.indexOf(id);
          if (index == -1) return false;
          playerId.remove(index);
          scores.remove(index);
          int newP = 0;
          for (int i = 0; i < scores.size(); i++) {
              if (scores.get(i) > newScore) newP++;
          }
          playerId.add(newP, id);
          scores.add(newP, newScore);
          return true;
      }

      public static void displayLeaderboard(ArrayList<Integer> playerIds, ArrayList<Integer> scores) {
          System.out.println("------------LEADERBOARD------------");
          System.out.println("Rank Player ID Score");
          for (int i = 0; i < playerIds.size(); i++) {
              System.out.printf("%d %d %d%n", i + 1, playerIds.get(i), scores.get(i));
          }
      }

      public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          ArrayList<Integer> playerIds = new ArrayList<>(50);
          ArrayList<Integer> scores = new ArrayList<>(50);
          int choice = 0;

          while (choice != 6) {
              System.out.println("1 - Add Player");
              System.out.println("2 - Update Player Score");
              System.out.println("3 - Remove Players Below Threshold");
              System.out.println("4 - Display Player");
              System.out.println("5 - Display Leaderboard");
              System.out.println("6 - Exit");
              System.out.print("Enter choice: ");
              choice = scanner.nextInt();

              if (choice == 1) {
                  System.out.print("Enter player id and score: ");
                  int id = scanner.nextInt();
                  int score = scanner.nextInt();
                  if (playerIds.size() >= 50) {
                      System.out.println("Leaderboard is full");
                  } else if (findPlayer(playerIds, id) != -1) {
                      System.out.println("Player ID already exists");
                  } else if (score < 0) {
                      System.out.println("Score must be non-negative");
                  } else {
                      insertPlayer(playerIds, scores, id, score);
                      System.out.println("player added");
                  }
              } else if (choice == 2) {
                  System.out.print("Enter player id and score: ");
                  int id = scanner.nextInt();
                  int newScore = scanner.nextInt();
                  boolean updated = updateScore(playerIds, scores, id, newScore);
                  if (updated) System.out.println("score updated");
                  else System.out.println("Could not update score");
              } else if (choice == 3) {
                  System.out.print("Enter threshold: ");
                  int threshold = scanner.nextInt();
                  removeBelow(playerIds, scores, threshold);
                  System.out.println("players with score below " + threshold + " removed");
              } else if (choice == 4) {
                  System.out.print("Enter player id: ");
                  int id = scanner.nextInt();
                  int index = findPlayer(playerIds, id);
                  if (index == -1) System.out.println("player with id " + id + " not found");
                  else System.out.println("Player ID: " + playerIds.get(index) + " Player Score: " + scores.get(index));
              } else if (choice == 5) {
                  displayLeaderboard(playerIds, scores);
              } else if (choice == 6) {
                  System.out.println("Exiting...");
              } else {
                  System.out.println("please enter valid choice");
              }
              System.out.println();
          }
          scanner.close();
      }
  }
