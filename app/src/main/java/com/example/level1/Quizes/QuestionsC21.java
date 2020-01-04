package com.example.level1.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionsC21 implements Parcelable {

    private String questionC21;
    private String option1C21;
    private String option2C21;
    private String option3C21;
    private int answerNrC21;


    public QuestionsC21() {
    }

    public QuestionsC21(String questionC21, String option1C21, String option2C21, String option3C21, int answerNrC21) {
        this.questionC21 = questionC21;
        this.option1C21 = option1C21;
        this.option2C21 = option2C21;
        this.option3C21 = option3C21;
        this.answerNrC21 = answerNrC21;
    }

    protected QuestionsC21(Parcel in) {
        questionC21 = in.readString();
        option1C21 = in.readString();
        option2C21 = in.readString();
        option3C21= in.readString();
        answerNrC21 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionC21);
        dest.writeString(option1C21);
        dest.writeString(option2C21);
        dest.writeString(option3C21);
        dest.writeInt(answerNrC21);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<QuestionsC21> CREATOR = new Parcelable.Creator<QuestionsC21>() {
        @Override
        public QuestionsC21 createFromParcel(Parcel in) {
            return new QuestionsC21(in);
        }

        @Override
        public QuestionsC21[] newArray(int size) {
            return new QuestionsC21[size];
        }
    };


    public String getQuestionC21() {
        return questionC21;
    }

    public void setQuestionC21(String questionC21) {
        this.questionC21 = questionC21;
    }

    public String getOption1C21() {
        return option1C21;
    }

    public void setOption1C21(String option1C21) {
        this.option1C21 = option1C21;
    }

    public String getOption2C21() {
        return option2C21;
    }

    public void setOption2C21(String option2C21) {
        this.option2C21 = option2C21;
    }

    public String getOption3C21() {
        return option3C21;
    }

    public void setOption3C21(String option3C21) {
        this.option3C21 = option3C21;
    }

    public int getAnswerNrC21() {
        return answerNrC21;
    }

    public void setAnswerNrC21(int answerNrC21) {
        this.answerNrC21 = answerNrC21;
    }
}
