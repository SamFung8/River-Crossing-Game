package Puzzle.UI;
import java.util.ArrayList;


public class DrawGraphic{
    // Colors list
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String WHITE = "\033[0;37m";   // WHITE
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String BLACK = "\033[0;30m";   // BLACK

    // Graphics setting
    public static final int width = 50;
    public static final int height = 10;
	
	public void draw(ArrayList<String> tRoles, ArrayList<String> bRoles, int bPosition, ArrayList<String> bSit){
    	System.out.println();
        for(int i=0;i<tRoles.size();i++){
            findRoleColor(tRoles.get(i));
        }
        System.out.println();
        
        for(int i=0; i < width; i++){
        	System.out.print(GREEN + "= ");
        }        
        System.out.println();
        
        drawBoat(bPosition, bSit);
        
        for(int i=0; i < width; i++){
        	System.out.print(GREEN + "= ");
        }
        System.out.println();
        
        for(int i=0;i<bRoles.size();i++){
            findRoleColor(bRoles.get(i));
        }
        System.out.println(WHITE);
        System.out.println("\n---------------------------------------------------------------------------------------------------------");
    }
    
    public void findRoleColor(String r){
    	System.out.print(YELLOW_BOLD + r + " ");
    }
    
    public void drawBoatSit(ArrayList<String> s, int boatIconLength) {
    	int totalLength = 0;
    	
    	System.out.print(CYAN_BOLD + "[   ");
    	if(s.size()==2) {
    		totalLength = s.get(0).length() + s.get(1).length();
    		findRoleColor(s.get(0));
    		for (int i =0;i<boatIconLength-totalLength-8;i++) {
    			System.out.print(" ");
    		}
    		findRoleColor(s.get(1));
    	}else if(s.size()==1) {
    		totalLength = s.get(0).length();
    		findRoleColor(s.get(0));
    		for (int i =0;i<boatIconLength-totalLength-8;i++) {
    			System.out.print(" ");
    		}
    	}else {
    		for (int i =0;i<boatIconLength-totalLength-8;i++) {
    			System.out.print(" ");
    		}
    	}
		System.out.print(CYAN_BOLD + "  ]");
    }  
    
    
    public void drawBoat(int p, ArrayList<String> sit){
        int deep = height - 4;
        int widthSpace = width/2 - 4;
        String boatIcon = ". . . . . . . . . B o a t . . . . . . . . . ";
                
        if(p == 1){
            for(int i=0; i < width - widthSpace - boatIcon.length()/2; i++){
                System.out.print(WHITE + "~ ");
            }
            drawBoatSit(sit, boatIcon.length());
            for(int i=0; i < widthSpace; i++){
                System.out.print(WHITE + "~ ");
            }
            System.out.println();
            for(int i=0; i < width - widthSpace - boatIcon.length()/2; i++){
                System.out.print(WHITE + "~ ");
            }
            System.out.print(CYAN_BOLD + boatIcon);
            for(int i=0; i < widthSpace; i++){
                System.out.print(WHITE + "~ ");
            }
            System.out.println();
            for(int i=0; i < deep; i++){
                for(int j=0; j < width; j++){
                    System.out.print(WHITE + "~ ");
                }
                System.out.println();
            }
        }else {
            for(int i=0; i < deep; i++){
                for(int j=0; j < width; j++){
                    System.out.print(WHITE + "~ ");
                }
                System.out.println();
            }
            for(int i=0; i < width - widthSpace - boatIcon.length()/2; i++){
                System.out.print(WHITE + "~ ");
            }
            System.out.print(CYAN_BOLD + boatIcon);
            for(int i=0; i < widthSpace; i++){
                System.out.print(WHITE + "~ ");
            }
            System.out.println();
            for(int i=0; i < width - widthSpace  - boatIcon.length()/2; i++){
                System.out.print(WHITE + "~ ");
            }
            drawBoatSit(sit, boatIcon.length());
            for(int i=0; i < widthSpace; i++){
                System.out.print(WHITE + "~ ");
            }
            System.out.println();
        }
    }
}
