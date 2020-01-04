package com.example.level1.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionsC22  implements Parcelable {

    private String questionC22;
    private String option1C22;
    private String option2C22;
    private String option3C22;
    private int answerNrC22;


    public QuestionsC22() {
    }

    public QuestionsC22(String questionC22, String option1C22, String option2C22, String option3C22, int answerNrC22) {
        this.questionC22 = questionC22;
        this.option1C22 = option1C22;
        this.option2C22 = option2C22;
        this.option3C22 = option3C22;
        this.answerNrC22 = answerNrC22;
    }

    protected QuestionsC22(Parcel in) {
        questionC22 = in.readString();
        option1C22 = in.readString();
        option2C22 = in.readString();
        option3C22= in.readString();
        answerNrC22 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionC22);
        dest.writeString(option1C22);
        dest.writeString(option2C22);
        dest.writeString(option3C22);
        dest.writeInt(answerNrC22);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<QuestionsC22> CREATOR = new Parcelable.Creator<QuestionsC22>() {
        @Override
        public QuestionsC22 createFromParcel(Parcel in) {
            return new QuestionsC22(in);
        }

        @Override
        public QuestionsC22[] newArray(int size) {
            return new QuestionsC22[size];
        }
    };


    public String getQuestionC22() {
        return questionC22;
    }

    public void setQuestionC22(String questionC22) {
        this.questionC22 = questionC22;
    }

    public String getOption1C22() {
        return option1C22;
    }

    public void setOption1C22(String option1C22) {
        this.option1C22 = option1C22;
    }

    public String getOption2C22() {
        return option2C22;
    }

    public void setOption2C22(String option2C22) {
        this.option2C22 = option2C22;
    }

    public String getOption3C22() {
        return option3C22;
    }

    public void setOption3C22(String option3C22) {
        this.option3C22 = option3C22;
    }

    public int getAnswerNrC22() {
        return answerNrC22;
    }

    public void setAnswerNrC22(int answerNrC22) {
        this.answerNrC22 = answerNrC22;
    }
}
