let realEstateApi = Vue.resource('/app/realty{/id}');

Vue.component('realEstate-row',{
    props: ['realEstate'],
    template:
        '<li>' +
        '{{ realEstate.city }},ул.{{realEstate.street}}, д.{{realEstate.houseNumber}}'+
        '<span>'+
            '<button @click="info">Details</button>'+
            '<button @click="deleteRealty">delete</button>'+
        '</span>'+
        '</li>',
     methods: {
        info: function(){
            localStorage.realty = JSON.stringify(this.realEstate)
            document.location="info.html"
        },
        deleteRealty: function(){
            realEstateApi.delete({id:this.realEstate.id});
        }
     }

});

Vue.component('paginated-list',{
  data(){
    return {
      pageNumber: 0,
      cityName: '',
      realEstate: null
    }
  },
  props:{
    listData:{
      type:Array,
      required:true
    },
    size:{
      type:Number,
      required:false,
      default: 5
    }
  },
  methods:{
      nextPage(){
         this.pageNumber++;
      },
      prevPage(){
        this.pageNumber--;
      },
      sortByCheapest(){
           this.listData.sort(function(a,b){
                return a.price - b.price;
           });
      },

      sortByExpensive(){
            this.listData.sort(function(a,b){
                return b.price - a.price;
            });
      },

        filterByCityName(){
           this.listData = this.listData.filter(obj => obj.city == this.cityName)
        },

        reset(){
            this.listData = this.realEstateList;
        }
  },
  computed:{
    pageCount(){
      let l = this.listData.length,
          s = this.size;
      return Math.ceil(l/s);
    },
    paginatedData(){
      const start = this.pageNumber * this.size,
            end = start + this.size;
      return this.listData
               .slice(start, end);
    },

  },
  template: '<div>'+
                '<div><button @click="sortByCheapest">Sort by cheapest</button><button @click="sortByExpensive">Sort by expensive</button></div>'+
                '<div>Filter</div>'+
                '<div><input type="text" placeholder="City name" v-model="cityName"><button @click="filterByCityName">filter</button></div>'+
                '<div><button @click="reset">Reset</button></div>'+
               '<ul>'+
                  '<realEstate-row v-for="realEstate in paginatedData" :key="realEstate.id" :realEstate="realEstate" />'+
               '</ul>'+
              '<button :disabled="pageNumber === 0" @click="prevPage">Previous</button>'+
              '<button :disabled="pageNumber >= pageCount -1" @click="nextPage">Next</button>'+
             '</div>',

          created: function(){
              realEstateApi.get().then(result =>
                  result.json().then(data =>{
                        data.forEach(realty => this.listData.push(realty));
                        this.realEstateList = this.listData;
                  }
                  )
              )
       }

});

Vue.component('realEstate-list',{
    props: ['realEstateList'],
    template: '<div>' +
                 '<realEstate-row v-for="realEstate in realEstateList" :key="realEstate.id" :realEstate="realEstate" />'
              +'</div>',
        created: function(){
            realEstateApi.get().then(result =>
                result.json().then(data =>
                    data.forEach(realty => this.realEstateList.push(realty))

                )
            )
     }

});

let app = new Vue({
  el: '#app',
  template: '<paginated-list :list-data="realEstateList"/>',
  data: {
    realEstateList: []
  }
});