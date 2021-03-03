
Vue.component('info-real-estate',{
    props:['realEstate'],

    template: '<div>{{realEstate}}</div>'

});

let app = new Vue({
  el: '#info',
  template: '<div><info-real-estate :realEstate="realEstate" /></div>',
  data: {
        realEstate: JSON.parse(localStorage.realty)
  }
});