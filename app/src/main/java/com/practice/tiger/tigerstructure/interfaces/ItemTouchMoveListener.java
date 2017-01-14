package com.practice.tiger.tigerstructure.interfaces;

/**
 * Author：NaShichao
 * Time：2016/12/27  下午8:01
 * Email：na.shichao@163.com
 * Description：
 */

public interface ItemTouchMoveListener {
    boolean onItemMove(int fromPosition, int toPosition);
    boolean onItemRemove(int position);
}
