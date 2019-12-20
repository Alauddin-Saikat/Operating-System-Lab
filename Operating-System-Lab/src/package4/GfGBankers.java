/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package4;

/**
 *
 * @author User
 */
public class GfGBankers {
    
    int n=5,m=3;  // n Number of processes , m number of resources 
    int need[][] = new int[n][m];
    int max[][];
    int alloc[][];
    int work[];
    int safeSequence[] = new int[n];
    
    void initializeValues(){
        alloc = new int [][]{
            { 0, 1, 0 }, //p0
            { 2, 0, 0 }, //P1 
            { 3, 0, 2 }, //P2 
            { 2, 1, 1 }, //P3 
            { 0, 0, 2 }  //p4
        };
        
        // MAX Matrix 
        max = new int[][] { { 7, 5, 3 }, //P0 
             { 3, 2, 2 }, //P1 
             { 9, 0, 2 }, //P2 
             { 2, 2, 2 }, //P3  
             { 4, 3, 3 } }; //P4
        
        work = new int [] {3 ,3, 2};
    }
    
    void calculateNeed(){
        for(int i=0 ; i<n ; i++){
            for (int j=0 ; j<m ; j++ ){
                need[i][j]= max[i][j] - alloc[i][j];
            }
        }
    }
    
    void isSafe(){
        int count =0 ;
        //visited array already to alocated process 
        boolean visited[] =new boolean[n];
        for(int i=0 ;i<n ; i++)
            visited[i] = false;
        
        while ( count<n ){
            boolean flag =false;
            
            for(int i=0 ; i<n ;i++){
                if (!visited[i]){
                    int j;
                    for ( j=0 ; j<m ; j++){
                        if(work[j] < need[i][j])
                            break;
                    }
                    if(j==m){
                        safeSequence[count++]=i;
                        visited[i]=true;
                        flag = true;
                        
                        for(j=0 ;j<m ;j++)
                        {
                            work[j]=work[j]+alloc[i][j];
                        }
                    }
                }
            }
            if(flag == false )
                break;
        }
        
        if(count < n)
        {
            System.out.println("System is unsafe");
        }
        else {
            System.out.println("safe sequence is : ");
            for(int i=0 ; i<n ; i++)
                System.out.println("P"+safeSequence[i]+ "  ");
        }
    }
    
    
    
    
    public static void main(String[] args) {
        int i , j ,k;
        
        GfGBankers gfg = new GfGBankers();
        
        gfg.initializeValues();
        
        gfg.calculateNeed();
        
        gfg.isSafe();
    }
}
