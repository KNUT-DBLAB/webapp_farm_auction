"use strict";(self["webpackChunkfront"]=self["webpackChunkfront"]||[]).push([[889],{5889:function(e,l,n){n.r(l),n.d(l,{default:function(){return V}});var o=n(3396),t=n(7139),a=n(9242);const s={class:"welcome-header1"},r=(0,o._)("h1",{class:"welcome-header__title1"},"따 과 농 과",-1),u={class:"welcome-header__text1"},i={class:"login_keep_wrap",id:"login_keep_wrap"},c={class:"keep_check"},p=(0,o._)("input",{type:"checkbox",id:"keep",name:"nvlong",class:"input_keep",value:"on"},null,-1),d=(0,o._)("label",{for:"keep",class:"keep_text"},"로그인 상태 유지",-1),m=(0,o._)("br",null,null,-1),_=(0,o._)("br",null,null,-1),h=(0,o._)("label",{for:"consumer"},"소비자",-1),f=(0,o._)("br",null,null,-1),k=(0,o._)("label",{for:"farm"},"농가",-1),w=(0,o._)("br",null,null,-1),b=(0,o._)("button",{class:"login-form__btn",type:"submit"},"회원가입",-1),g=(0,o._)("a",{class:"login-form__a",href:"#"},"아이디 찾기",-1);function v(e,l,n,v,y,U){const C=(0,o.up)("router-link");return(0,o.wg)(),(0,o.iD)("div",null,[(0,o._)("header",s,[r,(0,o._)("p",u,(0,t.zw)(this.$store.state.test.id),1)]),(0,o._)("form",{onSubmit:l[5]||(l[5]=(0,a.iM)(((...l)=>e.submitForm&&e.submitForm(...l)),["prevent"])),class:"login-form"},[(0,o._)("div",null,[(0,o.wy)((0,o._)("input",{class:"login-form__input",type:"text",id:"name","onUpdate:modelValue":l[0]||(l[0]=e=>y.email=e)},null,512),[[a.nr,y.email]])]),(0,o._)("div",null,[(0,o.wy)((0,o._)("input",{class:"login-form__input",type:"password",id:"password","onUpdate:modelValue":l[1]||(l[1]=e=>y.password=e)},null,512),[[a.nr,y.password]])]),(0,o._)("div",i,[(0,o._)("div",c,[p,d,m,_,(0,o.wy)((0,o._)("input",{type:"radio",id:"consumer",value:"consumer","onUpdate:modelValue":l[2]||(l[2]=e=>y.checkUser=e)},null,512),[[a.G2,y.checkUser]]),h,f,(0,o.wy)((0,o._)("input",{type:"radio",id:"farm",value:"farm","onUpdate:modelValue":l[3]||(l[3]=e=>y.checkUser=e)},null,512),[[a.G2,y.checkUser]]),k,w])]),(0,o._)("button",{class:"login-form__btn",type:"submit",onClick:l[4]||(l[4]=e=>U.login())},"로그인"),(0,o.Wm)(C,{to:"/clause"},{default:(0,o.w5)((()=>[b])),_:1}),g],32)])}var y=n(6265),U=n.n(y),C={name:"SignupForm",data(){return{checkUser:"consumer",email:null,password:null,token:null}},methods:{login(){let e=new FormData;e.append("emailCheckUser",this.email+":"+this.checkUser),e.append("password",this.password),console.log(e),U().post("http://localhost:8080/api/login",e,{headers:{"Content-Type":"multipart/form-data"}}).then((e=>{console.log(e),""==e.data?(alert("아이디 또는 비밀번호가 틀렸습니다!"),console.log("....")):this.$router.push({name:"main",params:e.data.token})})).catch((e=>{console.log(e)}))}}},x=n(89);const F=(0,x.Z)(C,[["render",v]]);var V=F}}]);
//# sourceMappingURL=889.baa86c54.js.map