package com.example.level1.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionsC12 implements Parcelable {

    private String questionC12;
    private String option1C12;
    private String option2C12;
    private String option3C12;
    private int answerNrC12;


    public QuestionsC12() {
    }

    public QuestionsC12(String questionC12, String option1C12, String option2C12, String option3C12, int answerNrC12) {
        this.questionC12 = questionC12;
        this.option1C12 = option1C12;
        this.option2C12 = option2C12;
        this.option3C12 = option3C12;
        this.answerNrC12 = answerNrC12;
    }

    protected QuestionsC12(Parcel in) {
        questionC12 = in.readString();
        option1C12 = in.readString();
        option2C12 = in.readString();
        option3C12= in.readString();
        answerNrC12 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionC12);
        dest.writeString(option1C12);
        dest.writeString(option2C12);
        dest.writeString(option3C12);
        dest.writeInt(answerNrC12);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<QuestionsC12> CREATOR = new Parcelable.Creator<QuestionsC12>() {
        @Override
        public QuestionsC12 createFromParcel(Parcel in) {
            return new QuestionsC12(in);
        }

        @Override
        public QuestionsC12[] newArray(int size) {
            return new QuestionsC12[size];
        }
    };

    public String getQuestionC12() {
        return questionC12;
    }

    public void setQuestionC12(String questionC12) {
        this.questionC12 = questionC12;
    }

    public String getOption1C12() {
        return option1C12;
    }

    public void setOption1C12(String option1C12) {
        this.option1C12 = option1C12;
    }

    public String getOption2C12() {
        return option2C12;
    }

    public void setOption2C12(String option2C12) {
        this.option2C12 = option2C12;
    }

    public String getOption3C12() {
        return option3C12;
    }

    public void setOption3C12(String option3C12) {
        this.option3C12 = option3C12;
    }

    public int getAnswerNrC12() {
        return answerNrC12;
    }

    public void setAnswerNrC12(int answerNrC12) {
        this.answerNrC12 = answerNrC12;
    }
}
