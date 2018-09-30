package com.eco.ecoseoul.mypage.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.eco.ecoseoul.R
import com.eco.ecoseoul.mypage.control.FAQAdapter
import com.eco.ecoseoul.mypage.model.FAQItem
import kotlinx.android.synthetic.main.activity_faq.*

class FAQActivity : AppCompatActivity() {

    lateinit var expandableAdapter: FAQAdapter
    lateinit var expandableItems : ArrayList<FAQItem>
    lateinit var expandableRecycler : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faq)

        var paText : String
        var chText : String

        expandableItems = ArrayList()
        var parent = FAQItem(0,"회원가입은 어떻게 하나요?",null)
        parent.invisibleChildren = ArrayList()
        parent.invisibleChildren!!.add(FAQItem(1,"주소 및 아파트 등록 문제로 애플리케이션 내에서는 회원가입이 어렵습니다. 서울시 에코마일리지 홈페이지에서 회원가입이 가능합니다. (https://ecomileage.seoul.go.kr/home/join.do?menuNo=21)",null))


        parent = FAQItem(0,"현금 전환, 지방세 납부, 카드 포인트 적립 등은 어떻게 하나요?",null)
        parent.invisibleChildren = ArrayList()
        parent.invisibleChildren!!.add(FAQItem(1,"문의하신 사용 방법들은 에코마일리지 홈페이지가 아닌 E-Tax 등의 홈페이지 방문이 필요하여 앱 내에서는 사용이 어렵습니다. 자세한 설명은 이 곳을 참고하세요. (http://ecomileage.seoul.go.kr/home/incentives/card.do?menuNo=6)",null))
        expandableItems.add(parent)

        paText = "거주지 이전 시 주소변경 관련 "
        chText = "회원님께서 새로운 곳으로 이사를 하셔도 에코마일리지 상 주소는 자동으로 변경되지 않습니다. 거주지를 이전하셨을 때에는 서울시 에코마일리지 웹 홈페이지에서 직접 에코마일리지 홈페이지에서 '마이페이지->회원정보수정'란으로 들어가신 후 변경하셔야 합니다."
        parent = FAQItem(0,paText,null)
        parent.invisibleChildren = ArrayList()
        parent.invisibleChildren!!.add(FAQItem(1,chText,null))
        expandableItems.add(parent)

        paText = "마일리지로 상품 신청시 배송일정 안내 "
        chText = "배송일정은 서울시 에코마일리지 웹 홈페이지의 [알림터 -> 공지사항 -> 인센티브 신청상품 배송안내]를 참고해주세요.\n" +
                "(http://ecomileage.seoul.go.kr/home/board/view.do?pageIndex=1&pageUnit=10&pageSize=10&searchCondition=&searchKeyword=&menuNo=8&condition.noticeYn=N&condition.boardMasterId=14&condition.deleteYn=N&boardId=264&boardMasterId=14)"
        parent = FAQItem(0,paText,null)
        parent.invisibleChildren = ArrayList()
        parent.invisibleChildren!!.add(FAQItem(1,chText,null))
        expandableItems.add(parent)

        paText = "에코마일리지 인센티브 선정절차는 어떻게 되나요?"
        chText = "1. 평가대상월 : 가입월 다음월 부터 6개월 (5월 가입자는 6월~11월까지 평가)\n" +
                "2. 인센티브 선정 절차\n" +
                "(1) 6개월간 5%이상 절감 대상자 선정(2016년부터) : 1일 ~ 3일\n" +
                "(2) 주민등록번호를 등록하도록 SMS발송(기 주민등록번호 등록회원은 제외) : 3일 ~ 10일\n" +
                "(3) 주민등록번호 수집 후 주민등록관리부서에 현재 거주지 주소자료 요청 : 10일 ~ 20일\n" +
                "(4) 주민등록상의 주소와 회원정보의 주소정보를 자치구청에 통보 : 20일 ~ 25일\n" +
                "(5) 주소일치 회원 확정(자치구에서 작업) : 25일 이후\n" +
                "(6) 확정된 회원 마일리지 지급"
        parent = FAQItem(0,paText,null)
        parent.invisibleChildren = ArrayList()
        parent.invisibleChildren!!.add(FAQItem(1,chText,null))
        expandableItems.add(parent)

        paText = "에코마일리지 계산법궁금해요 "
        chText = "인센티브 지급기준 \n" +
                "- 평가대상기간 : 가입월 다음월 부터 시작(8월가입자는 9월 부터 6개월씩) \n" +
                "- 기준사용량 : 전년+전전년의 기간 사용량의 평균 \n" +
                "ex) 2014년 4월가입자 기준\n" +
                "평가대상기간은 2014년 5월 ~ 10월, 11월~ 2015년5월….이며\n" +
                " \n" +
                "- 절감량은 탄소배출량으로 환산한 후 계산됩니다. \n" +
                "ex) 전기사용량 : 100kw, 가스사용량 : 10m3, 수도물 : 10m3 \n" +
                "=> 100*0.424 =42.4, 가스 10*2.24=22.4, 수도물 10*0.332\\3.32 \n" +
                "※ 탄소환산계수 : 전기(0.424/kw), 가스(2.24/m3), 수도물(0.332/m3) \n" +
                "질문하신 310Kw -> 257Kw, 수도34.2 -> 30 \n" +
                "(수도사용량은 임의로 30를 설정했습니다.) \n" +
                "전기 절감량 : 257*0.424-310*0.424 = -22.472 \n" +
                "수도절감량 : 30*0.332-34.2*0.332 = -1.3944 \n" +
                "총절감량 : -23.8664 \n" +
                "전기수도기준사용량 : 310*0.424+34.2*0.332 = 142.794 \n" +
                "절감율 : 총절감량 / 기준사용량 -16.71% "

        parent = FAQItem(0,paText,null)
        parent.invisibleChildren = ArrayList()
        parent.invisibleChildren!!.add(FAQItem(1,chText,null))
        expandableItems.add(parent)

        paText = "에코마일리지 카드가입은 어떻게 하나요? "
        chText = "에코마일리지 멤버십 카드 신청은  에코머니 홈페이지(http://ecomoney.co.kr/)에 접속 → 카드소개/신청→멤버십카드 메뉴를 이용하여 신청해주시면 됩니다.\n" +
                "에코마일리지 신용 및 체크카드 신청은  가까운 은행 영업점에 가서 직접 신청하시면 됩니다."

        parent = FAQItem(0,paText,null)
        parent.invisibleChildren = ArrayList()
        parent.invisibleChildren!!.add(FAQItem(1,chText,null))
        expandableItems.add(parent)

        expandableAdapter = FAQAdapter(expandableItems)

        expandableRecycler = findViewById(R.id.faq_recycler)

        expandableRecycler.layoutManager = LinearLayoutManager(this@FAQActivity, LinearLayoutManager.VERTICAL,false)
        expandableRecycler.adapter = expandableAdapter

        faq_close.setOnClickListener {
            finish()
        }

    }
}
