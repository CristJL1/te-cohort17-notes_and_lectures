<template>
  <div class="container"> <!-- main and ONLY <div> for the Vue application -->
    <Home /> <!-- use a Vue component called home (should be kebob-case) it's not because it's one word-->
    <router-view :key="$route.fullPath" class="routerView" /> <!-- using the Vue router -->
    <!-- :key="route.fullpath" force Vue to reload the component instead of reusing on each reference
                  to be sure Vue goes through it's lifecycle so any lifecycle hook executes
                      if you have a created() hook, it will only be run once if this is not coded
                        so to be sure the created() hook runs everytime the page is referenced
                        code :key="$route.fullpath" -->
  </div>
</template>

<script>
import Home from '@/components/Home';

export default {
  components: {
   Home
  }
};
</script>

<style>
body {
  font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto,
    'Helvetica Neue', Arial, 'Noto Sans', sans-serif, 'Apple Color Emoji',
    'Segoe UI Emoji', 'Segoe UI Symbol', 'Noto Color Emoji';
}
.container {
  width: 100%;
  max-width: 1100px;
  margin: 0 auto;
}
.loading {
  display: flex;
  justify-content: center;
  align-items: center;
}
.routerView {
  width: 79%;
  position: absolute;
  right: 0;
}
.btn {
  display: inline-block;
  font-weight: 400;
  color: #212529;
  text-align: center;
  vertical-align: middle;
  border: 1px solid transparent;
  padding: .375rem .75rem;
  margin-right: 10px;
  margin-bottom: 5px;
  font-size: 1rem;
  line-height: 1.5;
  border-radius: .25rem;
  cursor: pointer;
}
</style>
