package Canvas.object;

import exception.CanvasException;

public class Canvas {

	  char[][] canvasArray;
	    int w, h;
	    public Canvas(){}
	    public Canvas(int w, int h) {
	        h+=2;
	        w+=2;
	        this.w = w;
	        this.h = h;
	        this.canvasArray = new char[h][w];
	        createLine(0, 0, this.w-1, 0, '-');
	        createLine(0, this.h-1, this.w-1, this.h-1, '-');
	        createLine(0, 1, 0, this.h-2, '|');
	        createLine(this.w-1, 1, this.w-1, this.h-2, '|');
	    }
	    
	    
	    public String renderCanvas() {
	        checkCanvas();
	        StringBuilder strBuilder = new StringBuilder();
	        for(int i=0;i<this.h;i++) {
	            for(int j=0;j<this.w;j++) {
	                strBuilder.append(this.canvasArray[i][j] == '\u0000'?' ':this.canvasArray[i][j]);
	            }
	            strBuilder.append("\n");
	        }
	        return strBuilder.toString().trim();
	    }
	    
	    
	    public void createLine(int x1, int y1, int x2, int y2, char mChar) {
	        checkCanvas();
	        for(int i=y1; i<=y2; i++) {
	            for(int j=x1; j<=x2; j++) {
	                this.canvasArray[i][j] = mChar;
	            }
	        }
	    }
	    
	    
	    public void rectangle(int x1, int y1, int x2, int y2, char mchar) {
	        checkCanvas();
	        createLine(x1,y1, x2, y1, mchar);
	        createLine(x1,y1, x1, y2, mchar);
	        createLine(x2,y1, x2, y2, mchar);
	        createLine(x1,y2, x2, y2, mchar);
	    }
	    
	    
	    
	    
	    public void bucketFill(int x, int y, char mchar) {
	        checkCanvas();
	        if((int)this.canvasArray[y][x] != 0) {
	            return;
	        }
	        if(x > 0 || x < this.h || y > 0 || y  < this.w) {
	            if((int)this.canvasArray[y][x] == 0)
	                this.canvasArray[y][x] = mchar;
	            bucketFill(x+1,y, mchar);
	            bucketFill(x-1,y, mchar);
	            bucketFill(x,y-1, mchar);
	            bucketFill(x,y+1, mchar);
	        }
	    }

	    private void checkCanvas() {
	        if(this.canvasArray == null)
	            throw new CanvasException("Draw a canvas first");
	    }
	
}
