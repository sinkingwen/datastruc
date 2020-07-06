package com.gui.sparsearray;

import java.io.*;

public class SparseArray {
    public static void main(String[] args) {
        int[][] chessArr1=new int[11][11];
        System.out.println("原来的稀疏数组~");
        for (int[] items:chessArr1) {
            for(int i=0;i<items.length;i++){
                System.out.printf("%d\t",items[i]);
            }
            System.out.println();
        }
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        chessArr1[3][4]=1;
        System.out.println("棋盘数组~");
        for (int[] items:chessArr1) {
            for(int i=0;i<items.length;i++){
                System.out.printf("%d\t",items[i]);
            }
            System.out.println();
        }
        int sum=0;
        for(int i=0; i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }

        System.out.println(sum);

        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        int count=0;
        for(int i=0; i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }
            }
        }
        System.out.println("稀疏数组~");
        for (int[] item:sparseArr) {
            for(int arr:item){
                System.out.printf("%d\t", arr);
            }
            System.out.println();
        }
//        File file = new File("sparseArray.txt");
//        FileOutputStream fos = null;
//        OutputStreamWriter osw =null;
//        BufferedWriter bw = null;
//        try {
//            fos = new FileOutputStream(file);
//            osw = new OutputStreamWriter(fos,"UTF-8");
//            bw = new BufferedWriter(osw);
//            System.out.println("稀疏数组~");
//            for (int[] item:sparseArr) {
//                for(int arr:item){
//                    bw.write(arr);
//                    bw.write("\t");
//                    System.out.printf("%d\t", arr);
//                }
//                System.out.println();
//            }
//            bw.close();
//            osw.close();
//            fos.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e){
//            e.printStackTrace();
//        }


        //把稀疏数组转成原棋盘数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int[] item:sparseArr) {
            for(int i=1; i<sparseArr[0][2]+1;i++){
                chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
            }
        }
        System.out.println("恢复的棋盘数组~");
        for (int[] items:chessArr2) {
            for(int i=0;i<items.length;i++){
                System.out.printf("%d\t",items[i]);
            }
            System.out.println();
        }
    }
}
