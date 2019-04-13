var FBL;
(function (FBL) {
    var Components;
    (function (Components) {
        var SideMenu = (function () {
            function SideMenu(selector) {
                this.root = $(selector);
                this.init();
            }
            SideMenu.prototype.init = function () {
                var _this = this;
                this.root.children(SideMenu.itemGroupSelector).each(function (groupIndex, group) {
                    _this.setupItemGroups($(group), 1);
                });
            };
            SideMenu.prototype.setupItemGroups = function (group, depth) {
                var _this = this;
                group
                    .addClass(SideMenu.itemGroupClass)
                    .addClass(SideMenu.itemGroupLevelClass + depth);
                group.children(SideMenu.itemSelector).each(function (itemIndex, item) {
                    _this.setupItems($(item), depth);
                });
            };
            SideMenu.prototype.setupItems = function (item, depth) {
                var _this = this;
                item
                    .addClass(SideMenu.itemClass)
                    .addClass(SideMenu.itemLevelClass + depth);
                var subGroup = item.children(SideMenu.itemGroupSelector);
                if (subGroup.length > 0) {
                    var anchor = item.children(SideMenu.itemGroupToggle).first()
                        .addClass(SideMenu.itemToggleClass)
                        .on("click", function (e) { return _this.onToggleClick($(e.target), e); });
                    this.setupItemGroups(subGroup.first(), depth + 1);
                }
            };
            SideMenu.prototype.onToggleClick = function (anchor, e) {
                e.preventDefault();
                anchor.siblings(SideMenu.itemGroupSelector).first()
                    .slideToggle(function () {
                    anchor
                        .toggleClass(SideMenu.itemGroupActiveClass)
                        .parent().toggleClass(SideMenu.itemActiveClass);
                });
            };
            SideMenu.register = function (selector) {
                return new SideMenu(selector);
            };
            SideMenu.itemGroupSelector = "ul";
            SideMenu.itemSelector = "li";
            SideMenu.itemGroupToggle = "a";
            SideMenu.itemGroupClass = "sidemenu-group";
            SideMenu.itemGroupLevelClass = "sidemenu-group-lvl-";
            SideMenu.itemGroupActiveClass = "sidemenu-group--active";
            SideMenu.itemClass = "sidemenu-item";
            SideMenu.itemLevelClass = "sidemenu-item-lvl-";
            SideMenu.itemActiveClass = "sidemenu-item--active";
            SideMenu.itemToggleClass = "sidemenu-item-toggle";
            return SideMenu;
        })();
        Components.SideMenu = SideMenu;
        $(function () {
            SideMenu.register(".sidemenu");
        });
    })(Components = FBL.Components || (FBL.Components = {}));
})(FBL || (FBL = {}));
var FBL;
(function (FBL) {
    var Components;
    (function (Components) {
        var Toggle = (function () {
            function Toggle() {
            }
            Toggle.register = function (initiator, getTarget, toggleClass, event) {
                if (toggleClass === void 0) { toggleClass = "toggled"; }
                if (event === void 0) { event = "click"; }
                initiator.on(event, function (e) {
                    getTarget($(e.target)).toggleClass(toggleClass);
                });
            };
            return Toggle;
        })();
        Components.Toggle = Toggle;
        $(function () {
            Toggle.register($('[data-toggle]'), function (t) { return $(t.data('toggle')); });
        });
    })(Components = FBL.Components || (FBL.Components = {}));
})(FBL || (FBL = {}));

//# sourceMappingURL=core.js.map
