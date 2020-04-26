package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    // 0-yellow;1-red

    int[] gameState={2,2,2,2,2,2,2,2,2};
    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int activePlayer=0;
    boolean gameActive=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void dropin(View view) {
        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter]==2 && gameActive){
        gameState[tappedCounter] = activePlayer;
      //  int tappedCounter = Integer.
        counter.setTranslationY(-1500);
        if (activePlayer ==0) {
            counter.setImageResource(R.drawable.yellow);
            //counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
            activePlayer=1;
        }else {
            counter.setImageResource(R.drawable.red);
            //counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
            activePlayer=0;
        }
        counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
        for(int[] winningPosition : winningPositions) {
            if (gameState[winningPosition[0]]==gameState[winningPosition[1]] && gameState[winningPosition[1]] != 2&&gameState[winningPosition[1]]==gameState[winningPosition[2]]) {
                String winner = "";
                if (activePlayer == 1) {
                    winner = "Yellow";
                   // Toast.makeText(this, winner, Toast.LENGTH_LONG).show();
                }
                if (activePlayer == 0) {
                    winner = "Red ";
                   // Toast.makeText(this, winner, Toast.LENGTH_LONG).show();
                }
                //Toast.makeText(this, winner, Toast.LENGTH_LONG).show();
                gameActive=false;
                Button playAgainBtn=findViewById(R.id.btn1);
                TextView winnerTv=findViewById(R.id.WinnerTv);
                winnerTv.setText(winner + " has won!!!!");
                playAgainBtn.setVisibility(View.VISIBLE);
                winnerTv.setVisibility(View.VISIBLE);

            }
        }
        }
        }

    public void playAgain(View view) {
        Button playAgainBtn=findViewById(R.id.btn1);
        TextView winnerTv=findViewById(R.id.WinnerTv);
        playAgainBtn.setVisibility(View.INVISIBLE);
        winnerTv.setVisibility(View.INVISIBLE);
        GridLayout grid=findViewById(R.id.grid);
        for(int i=0; i<grid.getChildCount(); i++) {
           ImageView child = (ImageView) grid.getChildAt(i);
           child.setImageDrawable(null);
           // do stuff with child view
        }
for (int i=0;i<gameState.length;i++)
{        gameState[i]=2;}
        // winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
         activePlayer=0;
         gameActive=true;
    }
}

