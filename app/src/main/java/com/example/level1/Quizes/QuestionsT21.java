package com.example.level1.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionsT21 implements Parcelable {

    private String questionT21;
    private String option1T21;
    private String option2T21;
    private String option3T21;
    private int answerNrT21;


    public QuestionsT21() {
    }

    public QuestionsT21(String questionT21, String option1T21, String option2T21, String option3T21, int answerNrT21) {
        this.questionT21 = questionT21;
        this.option1T21 = option1T21;
        this.option2T21 = option2T21;
        this.option3T21 = option3T21;
        this.answerNrT21 = answerNrT21;
    }

    protected QuestionsT21(Parcel in) {
        questionT21 = in.readString();
        option1T21 = in.readString();
        option2T21 = in.readString();
        option3T21= in.readString();
        answerNrT21 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionT21);
        dest.writeString(option1T21);
        dest.writeString(option2T21);
        dest.writeString(option3T21);
        dest.writeInt(answerNrT21);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuestionsT21> CREATOR = new Creator<QuestionsT21>() {
        @Override
        public QuestionsT21 createFromParcel(Parcel in) {
            return new QuestionsT21(in);
        }

        @Override
        public QuestionsT21[] newArray(int size) {
            return new QuestionsT21[size];
        }
    };

    public String getQuestionT21() {
        return questionT21;
    }

    public void setQuestionT21(String questionT21) {
        this.questionT21 = questionT21;
    }

    public String getOption1T21() {
        return option1T21;
    }

    public void setOption1T21(String option1T21) {
        this.option1T21 = option1T21;
    }

    public String getOption2T21() {
        return option2T21;
    }

    public void setOption2T21(String option2T21) {
        this.option2T21 = option2T21;
    }

    public String getOption3T21() {
        return option3T21;
    }

    public void setOption3T21(String option3T21) {
        this.option3T21 = option3T21;
    }

    public int getAnswerNrT21() {
        return answerNrT21;
    }

    public void setAnswerNrT21(int answerNrT21) {
        this.answerNrT21 = answerNrT21;
    }
}
