package com.melody.game.model;

public interface IDataLogicModel {

    interface DataListener {
        void onGenerateNewCard(int row, int col);
        void onOperateCard(int type);
        void onMoveCard(int originI, int originJ, int currentI, int currentJ, boolean isMerge);
        void onScoreChange();
    }

    class Builder {
        public static DataLogicModelImpl build(int rowNum, int colNum, DataListener dataListener) {
            return new DataLogicModelImpl(rowNum, colNum, dataListener);
        }
    }

}
