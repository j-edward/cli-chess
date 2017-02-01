/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

/**
 *
 * @author jhowell
 */
public interface IPiece {
    void onMove(int x, int y);
    void onDestroy();
}
