package cgui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class DialogueBox {
    private ArrayList<String> dialogueLines = new ArrayList<>();
    
    private boolean isActive;
    private int currentLineIndex;
    
    private GraphicsContext gc;
    private int scale;
    
    public DialogueBox(GraphicsContext gc, int scale) {
        this.gc = gc;
        this.scale = scale;
    }
    
    public void startDialogue(ArrayList<String> lines) {
        this.dialogueLines = lines;
        currentLineIndex = 0;
        isActive = true;
        
    }
    
    public void advanceLines() {
        currentLineIndex ++;
        if(currentLineIndex >= dialogueLines.size()){
            isActive = false;
        }
    }
    
    public void drawDialogueBox() {
        if(!isActive) return;
        
        gc.setFill(Paint.valueOf("Blue"));
        gc.fillRect(0, 576, 1536, 192);
        gc.setLineWidth(4);
        gc.strokeRect(0, 576, 1536, 192);
        gc.setFill(Paint.valueOf("White"));
        gc.setFont(Font.font("Monospaced", 24));
        gc.fillText(dialogueLines.get(currentLineIndex), 48, 576+64);
    }
    
    public boolean isActive() {
        return isActive;
    }
}
