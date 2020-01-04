package com.example.level1.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionsT11 implements Parcelable {

    private String questionT11;
    private String option1T11;
    private String option2T11;
    private String option3T11;
    private int answerNrT11;


    public QuestionsT11() {
    }

    public QuestionsT11(String questionT11, String option1T11, String option2T11, String option3T11, int answerNrT11) {
        this.questionT11 = questionT11;
        this.option1T11 = option1T11;
        this.option2T11 = option2T11;
        this.option3T11 = option3T11;
        this.answerNrT11 = answerNrT11;
    }

    protected QuestionsT11(Parcel in) {
        questionT11 = in.readString();
        option1T11 = in.readString();
        option2T11 = in.readString();
        option3T11= in.readString();
        answerNrT11 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionT11);
        dest.writeString(option1T11);
        dest.writeString(option2T11);
        dest.writeString(option3T11);
        dest.writeInt(answerNrT11);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuestionsT11> CREATOR = new Creator<QuestionsT11>() {
        @Override
        public QuestionsT11 createFromParcel(Parcel in) {
            return new QuestionsT11(in);
        }

        @Override
        public QuestionsT11[] newArray(int size) {
            return new QuestionsT11[size];
        }
    };


    public String getQuestionT11() {
        return questionT11;
    }

    public void setQuestionT11(String questionT11) {
        this.questionT11 = questionT11;
    }

    public String getOption1T11() {
        return option1T11;
    }

    public void setOption1T11(String option1T11) {
        this.option1T11 = option1T11;
    }

    public String getOption2T11() {
        return option2T11;
    }

    public void setOption2T11(String option2T11) {
        this.option2T11 = option2T11;
    }

    public String getOption3T11() {
        return option3T11;
    }

    public void setOption3T11(String option3T11) {
        this.option3T11 = option3T11;
    }

    public int getAnswerNrT11() {
        return answerNrT11;
    }

    public void setAnswerNrT11(int answerNrT11) {
        this.answerNrT11 = answerNrT11;
    }
}
