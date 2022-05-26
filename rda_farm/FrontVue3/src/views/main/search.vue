<template>
<div>
    <div class="main_nav_t_div">
        <nav class="main_t_nav">
            <ul class="main_t_nav_list">
                <li class="nav__btn">
                    <a class="nav__link" href="alert"><i class="fas fa-bell fa-2x" aria-hidden="true"></i>
                    </a>
                </li>

                <li class="nav__btn">
                    <a class="nav__link" href="/#"><i class="fas fa-running fa-2x" aria-hidden="true" image
                            src="../image/123.jpg"></i>
                    </a>
                </li>

                <li class="nav__btn">
                    <div class="nav__notification-dot"></div>
                    <a class="nav__link" href="regester_auction"><i class="fas fa-plus fa-2x" aria-hidden="true"></i>
                    </a>
                </li>
            </ul>
        </nav>
    </div>

    <div class="div_search">
        <input class="input_search" type="text" placeholder="검색어 입력" v-model="keyword">
        <button class="button_search"  @keyup.enter="searchresultshow(keyword)" >검색</button>
    </div>
    
    <fieldset>
        
        <h2 class="profileh2">최근 검색어</h2>
        <div class="main_div-1">
            <div class="btn_area_btm">
                <span class="btn_file">
                    <label for="inputImage" class="btn_model"><b id="btnChangeProfile" class="btn2"
                            onclick="">복숭아</b></label>
                </span>

                <span class="btn_file">
                    <label for="inputImage" class="btn_model"><b id="btnChangeProfile" class="btn2"
                            onclick="">복숭아</b></label>
                </span>

                <span class="btn_file">
                    <label for="inputImage" class="btn_model"><b id="btnChangeProfile" class="btn2"
                            onclick="">복숭아</b></label>
                </span>
                <span class="btn_file">
                    <label for="inputImage" class="btn_model"><b id="btnChangeProfile" class="btn2"
                            onclick="">복숭아</b></label>
                </span>

            </div>
        </div>
    </fieldset>

    <fieldset>
        <h2 class="profileh2">인기 검색어</h2>
        <div class="main_div-2">
        <div class="aside_area aside_popular">
            <h3 class="h_popular"><span></span></h3>
            <table class="tbl_home">
                <caption>
                    
                    <span></span>
                </caption>
                <colgroup>
                    <col>
                    <col width="60">
                    <col width="65">
                </colgroup>
                <thead>
                    <tr>
                        <th scope="col">구분</th>
                        <th scope="col">현재가</th>
                        <th scope="col">전일대비</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="up">
                        <th scope="row"><em>1.</em><a href="/item/main.naver?code=005930"
                                onclick="">사과</a>
                        </th>
                        <td>75,000</td>
                        <td><em class="bu_p bu_pup"><span class="blind">상승</span></em><span class="tah p11 red02"> 200
                            </span></td>
                    </tr>
                    <tr class="down">
                        <th scope="row"><em>2.</em><a href="/item/main.naver?code=096530"
                                onclick="">자두</a>
                        </th>
                        <td>50,000</td>
                        <td><em class="bu_p bu_pdn"><span class="blind">하락</span></em><span class="tah p11 nv01"> 300
                            </span></td>
                    </tr>
                    <tr class="down">
                        <th scope="row"><em>3.</em><a href="/item/main.naver?code=035720"
                                onclick="">복숭아</a>
                        </th>
                        <td>90,600</td>
                        <td><em class="bu_p bu_pdn"><span class="blind">하락</span></em><span class="tah p11 nv01"> 1,300
                            </span></td>
                    </tr>
                    <tr class="up">
                        <th scope="row"><em>4.</em><a href="/item/main.naver?code=011200"
                                onclick="">수박</a>
                        </th>
                        <td>27,800</td>
                        <td><em class="bu_p bu_pup"><span class="blind">상승</span></em><span class="tah p11 red02"> 2,550
                            </span></td>
                    </tr>
                    <tr class="up">
                        <th scope="row"><em>5.</em><a href="/item/main.naver?code=377330"
                                onclick="">호두</a>
                        </th>
                        <td>18,050</td>
                        <td><em class="bu_p bu_pup"><span class="blind">상승</span></em><span class="tah p11 red02"> 950
                            </span></td>
                    </tr>
                </tbody>
            </table>
            <a href="/sise/lastsearch2.naver" class="btn_more" onclick=""><em
                    class="btn_more4"><span class="blind">인기 검색 종목 더보기</span></em></a>
        </div>
    </div>
    </fieldset>
<bottom-nav></bottom-nav>
</div>
</template>

<script>
import bottomNav from '@/components/bottomNav.vue';

export default {
  name: "search",
  components: {bottomNav},
  data() {
    return {
      keyword: ''
    }
  },
  methods: {
    searchresultshow(keyword) {
      if (keyword !== ''){ //검색어를 입력한 경우
        this.$router.push({
          name: "SearchPage",
          params: {
            keyword: this.keyword,
            isResultShow: true,
          },
        });
        this.keyword = ''
        console.log('"',keyword,'"' + ' 검색')
      } else {
        alert('검색어를 입력해주세요!')  //검색어를 입력하지 않은 경우
      }
    },
  }
};

</script>
<style>
</style>